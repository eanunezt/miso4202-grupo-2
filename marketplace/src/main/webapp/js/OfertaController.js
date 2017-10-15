'use strict';

module.controller('OfertaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
    //listar
    $scope.lista = [];
    $scope.datosFormulario = {};
    $scope.panelEditar = false;
    $scope.listar=function(){
        $http.get('./rest/oferta', {})
            .success(function (data, status, headers, config) {
                $scope.lista = data;
            }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
        });    
    };

        $scope.listarProducto=function(){
            $http.get('./rest/producto', {})
                .success(function (data, status, headers, config) {
                    $scope.listaProducto = data;
                }).error(function (data, status, headers, config) {
                    alert('Error al consultar la informaci\xf3n de producto, por favor intente m\xe1s tarde');
            });    
        };
        $scope.listarProducto();
            $scope.listarCompra=function(){
            $http.get('./rest/compra', {})
                .success(function (data, status, headers, config) {
                    $scope.listaCompra = data;
                }).error(function (data, status, headers, config) {
                    alert('Error al consultar la informaci\xf3n de compra, por favor intente m\xe1s tarde');
            });    
        };
        $scope.listarCompra();
        

    $scope.listar();
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        $scope.datosFormulario = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        $http.post('./rest/oferta', JSON.stringify($scope.datosFormulario), {}
            ).success(function (data, status, headers, config) {
                alert("Los datos han sido guardados con Exito");
                $scope.panelEditar = false;
                $scope.listar();
            }).error(function (data, status, headers, config) {
                alert('Error al guardar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosFormulario = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosFormulario = JSON.parse(angular.toJson(data));
    };
    //eliminar
    $scope.eliminar = function (data){
        if (confirm('\xbfDesea elminar este registro?')) {    
            $http.delete('./rest/oferta/'+data.id, {})
                .success(function (data, status, headers, config) {
                    $scope.listar();
                }).error(function (data, status, headers, config) {    
                    alert('Error al eliminar la informaci\xf3n de Oferta, por favor intente m\xe1s tarde');
            });   
        }
    };
}]);
