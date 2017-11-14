'use strict';

angular.module('marketplace-autenticacion').controller('LoginCtrl', ['$rootScope','$scope', '$filter', '$http','$location','$window','$localStorage',function ($rootScope, $scope, $filter, $http, $location,$localStorage,$window) {

    $scope.datosFormulario = {};	

    $scope.login = function (callback) {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        $http.post('./rest/login', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                $scope.usuario = data;
                // store username and token in local storage to keep user logged in between page refreshes
                $localStorage.currentUser = { username: $scope.usuario, token: $scope.usuario.token }; 
                $rootScope.currentUser = $localStorage.currentUser;
                $http.defaults.headers.common.Authorization = 'Bearer ' + $scope.usuario.token;
                //callback(true);
                $location.url("http://localhost:8080/marketplace-core");
            }).error(function (data, status, headers, config) {
                alert('Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
    };
	
	
}]);