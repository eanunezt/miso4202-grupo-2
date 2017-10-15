'use strict';


// Declare app level module which depends on filters, and services
var app=angular.module('adminMarketplace', [
  'ngRoute',
  'angularUtils.directives.dirPagination',
  'adminMarketplace.controllers'
]);
app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {templateUrl: 'partials/menu.html'});
	$routeProvider.when('/Rol', {templateUrl: 'partials/Rol.html', controller: 'RolCtrl'});
	$routeProvider.when('/Compra', {templateUrl: 'partials/Compra.html', controller: 'CompraCtrl'});
	$routeProvider.when('/Producto', {templateUrl: 'partials/Producto.html', controller: 'ProductoCtrl'});
	$routeProvider.when('/Usuario', {templateUrl: 'partials/Usuario.html', controller: 'UsuarioCtrl'});
	$routeProvider.when('/Categoria', {templateUrl: 'partials/Categoria.html', controller: 'CategoriaCtrl'});
	$routeProvider.when('/Oferta', {templateUrl: 'partials/Oferta.html', controller: 'OfertaCtrl'});
	
  	$routeProvider.otherwise({redirectTo: '/'}); 
}]);

var module=angular.module("adminMarketplace.controllers",[]);
