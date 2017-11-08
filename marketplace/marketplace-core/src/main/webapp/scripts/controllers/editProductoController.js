

angular.module('marketplace-core').controller('EditProductoController', function($scope, $routeParams, $location, flash, ProductoResource , UsuarioResource, CategoriaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.producto = new ProductoResource(self.original);
            UsuarioResource.queryAll(function(items) {
                $scope.proveedorSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.producto.proveedor && item.id == $scope.producto.proveedor.id) {
                        $scope.proveedorSelection = labelObject;
                        $scope.producto.proveedor = wrappedObject;
                        self.original.proveedor = $scope.producto.proveedor;
                    }
                    return labelObject;
                });
            });
            CategoriaResource.queryAll(function(items) {
                $scope.categoriaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.producto.categoria && item.id == $scope.producto.categoria.id) {
                        $scope.categoriaSelection = labelObject;
                        $scope.producto.categoria = wrappedObject;
                        self.original.categoria = $scope.producto.categoria;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The producto could not be found.'});
            $location.path("/Productos");
        };
        ProductoResource.get({ProductoId:$routeParams.ProductoId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.producto);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The producto was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.producto.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Productos");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The producto was deleted.'});
            $location.path("/Productos");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.producto.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("proveedorSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.producto.proveedor = {};
            $scope.producto.proveedor.id = selection.value;
        }
    });
    $scope.$watch("categoriaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.producto.categoria = {};
            $scope.producto.categoria.id = selection.value;
        }
    });
    
    $scope.get();
});