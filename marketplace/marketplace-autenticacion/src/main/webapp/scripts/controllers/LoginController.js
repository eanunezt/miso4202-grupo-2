'use strict';

angular.module('marketplace-app').controller('LoginCtrl', ['$rootScope','$scope', '$filter', '$http','$location','$window','$localStorage',function ($rootScope, $scope, $filter, $http, $location,$window,$localStorage,usuarioService) {

    $scope.datosFormulario = {};
    
    $scope.obtenerUsuario = function(){
    	$scope.usuario = {};
        return $http.get('http://' + $window.location.host + '/' + $localStorage.producto.contexto + '/rest/usuarios/' + $scope.datosFormulario.usuario , {})
        .success(function (data, status, headers, config) {
        	$scope.usuario = data;
        }).error(function (data, status, headers, config) {
            alert('Error al consultar la informaci\xf3n de producto, por favor intente m\xe1s tarde');
        });
    }
    

    $scope.login = function () {
    	var promise = $scope.obtenerUsuario();
    	promise.then(
    			function(usuario) {
    				if(!usuario.data == ""){
    					usuario.data.passwd = $scope.datosFormulario.password;
    					$http.post('./rest/login', JSON.stringify(usuario.data), {}
    					).success(function (data, status, headers, config) {

    						$scope.usuario = data;
    						// store username and token in local storage to keep user logged in between page refreshes
    						$localStorage.currentUser = { user: $scope.usuario, token: $scope.usuario.password }; 
    						$rootScope.currentUser = $localStorage.currentUser;
    						$http.defaults.headers.common.Authorization = 'Bearer ' + $scope.usuario.password;
    						var url = "http://" + $window.location.host + "/" + $localStorage.producto.contexto;
    						$window.location.href=url;
    					}).error(function (data, status, headers, config) {
    						alert('Error al autenticar el usuario, Verifique que el usuario y la contraseña sean correctos.');
    					})
    				}
    				else{
    					alert('Error al autenticar el usuario, Verifique que usted se encuentre registrado.');
    				}
    			});

    };
    
    
    $scope.direccionar = function () {
    	var url = "../" + $localStorage.producto.contexto + "/app.html#/Usuarios/new";
    	location.href=url;
    };
    
}]);

