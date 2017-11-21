'use strict';

angular.module('marketplace-app',['ngRoute','ngResource','ngStorage'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Categoria',{templateUrl:'views/Categoria/search.html',controller:'SearchCategoriaController'})
      .when('/Categoria/new',{templateUrl:'views/Categoria/detail.html',controller:'NewCategoriaController'})
      .when('/Categoria/edit/:CategoriaId',{templateUrl:'views/Categoria/detail.html',controller:'EditCategoriaController'})
      .when('/Oferta',{templateUrl:'views/Oferta/search.html',controller:'SearchOfertaController'})
      .when('/Oferta/new',{templateUrl:'views/Oferta/detail.html',controller:'NewOfertaController'})
      .when('/Oferta/edit/:OfertaId',{templateUrl:'views/Oferta/detail.html',controller:'EditOfertaController'})
      .when('/Productos',{templateUrl:'views/Producto/search.html',controller:'SearchProductoController'})
      .when('/Productos/new',{templateUrl:'views/Producto/detail.html',controller:'NewProductoController'})
      .when('/Productos/edit/:ProductoId',{templateUrl:'views/Producto/detail.html',controller:'EditProductoController'})
      .when('/Usuarios',{templateUrl:'views/Usuario/search.html',controller:'SearchUsuarioController'})
      .when('/Usuarios/new',{templateUrl:'views/Usuario/detail.html',controller:'NewUsuarioController'})
      .when('/Usuarios/edit/:UsuarioId',{templateUrl:'views/Usuario/detail.html',controller:'EditUsuarioController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
/*.run(['$rootScope', '$http', '$location', '$localStorage', function($rootScope, $http, $location, $localStorage) {
    // keep user logged in after page refresh
    if ($localStorage.currentUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        $rootScope.currentUser = $localStorage.currentUser;
    }	
    
    // redirect to login page if not logged in and trying to access a restricted page
    $rootScope.$on(	'$locationChangeStart', function (event, next, current) {
        var publicPages = ['/Usuario'];
        var restrictedPage = publicPages.indexOf($location.path()) === -1;
        if (restrictedPage && !$localStorage.currentUser) {
            $location.path('/Login');
        }
    });    
	
}])*/
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
