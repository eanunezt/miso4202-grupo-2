
angular.module('marketplace-app').controller('NewProductoController', function ($scope, $location, locationParser, flash, ProductoResource , UsuarioResource, CategoriaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.producto = $scope.producto || {};
    
    $scope.proveedorList = UsuarioResource.queryAll(function(items){
        $scope.proveedorSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("proveedorSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.producto.proveedor = {};
            $scope.producto.proveedor.id = selection.value;
        }
    });
    
    $scope.categoriaList = CategoriaResource.queryAll(function(items){
        $scope.categoriaSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("categoriaSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.producto.categoria = {};
            $scope.producto.categoria.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The producto was created successfully.'});
            $location.path('/Productos');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        ProductoResource.save($scope.producto, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Productos");
    };
});