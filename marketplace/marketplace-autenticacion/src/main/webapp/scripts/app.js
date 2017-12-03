'use strict';

angular.module('marketplace-autenticacion',['ngRoute','ngResource','ngStorage'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Login', {templateUrl: 'views/Login.html', controller: 'LoginCtrl'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .run(['$rootScope', '$http', '$location', '$localStorage','$window', function($rootScope, $http, $location, $localStorage, $window) {
    // keep user logged in after page refresh

	$rootScope.producto = $localStorage.producto;

    if ($localStorage.currentUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        $rootScope.currentUser = $localStorage.currentUser;
    }	
    
    // redirect to login page if not logged in and trying to access a restricted page
    $rootScope.$on(	'$locationChangeStart', function (event, next, current) {
        var publicPages = ['','/about','/contact'];
        var restrictedPage = publicPages.indexOf($location.path()) === -1;
        if (restrictedPage && !$localStorage.currentUser) {
        	var url = "http://" + $window.location.host + "/marketplace-autenticacion";
            $window.location.href=url;
        }
        
    });    
	
}])
  .controller('LandingPageController', function LandingPageController($localStorage, $scope, $http) {
	  $scope.inicializar = function() {
          $http.get('./rest/init', {})
          .success(function (data, status, headers, config) {
        	  $localStorage.producto = data;
          }).error(function (data, status, headers, config) {
              alert('Error al consultar la informaci\xf3n de producto, por favor intente m\xe1s tarde');
      });  		  
	  };

  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  })
  .controller('LogoutCtrl', function LogoutController($rootScope,$scope,$localStorage,$http ){
	  $scope.logout = function(){
	      // remove user from local storage and clear http auth header
	      delete $localStorage.currentUser;
	      delete $rootScope.currentUser;
	      $http.defaults.headers.common.Authorization = '';	 
	  }
  });
