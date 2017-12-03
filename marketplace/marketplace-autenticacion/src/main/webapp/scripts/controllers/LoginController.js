'use strict';

angular.module('marketplace-autenticacion').controller('LoginCtrl', ['$rootScope','$scope', '$filter', '$http','$location','$window','$localStorage',function ($rootScope, $scope, $filter, $http, $location,$window,$localStorage) {

    $scope.datosFormulario = {};

    $scope.login = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        $http.post('./rest/login', JSON.stringify($scope.datosFormulario), {}
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
            });
        
    };
    
    
    $scope.direccionar = function () {
    	var url = "../" + $localStorage.producto.contexto + "/app.html#/Usuarios/new";
    	location.href=url;
    };
    
}]);