

angular.module('marketplace-compras').controller('EditCompraController', function($scope, $routeParams, $location, flash, CompraResource , ProductoResource, OfertaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.compra = new CompraResource(self.original);
            ProductoResource.queryAll(function(items) {
                $scope.productoSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.compra.producto && item.id == $scope.compra.producto.id) {
                        $scope.productoSelection = labelObject;
                        $scope.compra.producto = wrappedObject;
                        self.original.producto = $scope.compra.producto;
                    }
                    return labelObject;
                });
            });
            OfertaResource.queryAll(function(items) {
                $scope.ofertaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.compra.oferta && item.id == $scope.compra.oferta.id) {
                        $scope.ofertaSelection = labelObject;
                        $scope.compra.oferta = wrappedObject;
                        self.original.oferta = $scope.compra.oferta;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The compra could not be found.'});
            $location.path("/Compras");
        };
        CompraResource.get({CompraId:$routeParams.CompraId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.compra);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The compra was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.compra.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Compras");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The compra was deleted.'});
            $location.path("/Compras");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.compra.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("productoSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.compra.producto = {};
            $scope.compra.producto.id = selection.value;
        }
    });
    $scope.$watch("ofertaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.compra.oferta = {};
            $scope.compra.oferta.id = selection.value;
        }
    });
    
    $scope.get();
});