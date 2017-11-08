'use strict';

angular.module('marketplace-compras',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Compras',{templateUrl:'views/Compra/search.html',controller:'SearchCompraController'})
      .when('/Compras/new',{templateUrl:'views/Compra/detail.html',controller:'NewCompraController'})
      .when('/Compras/edit/:CompraId',{templateUrl:'views/Compra/detail.html',controller:'EditCompraController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
