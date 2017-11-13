

angular.module('marketplace-app').controller('EditCompraController', function($scope, $routeParams, $location, flash, CompraResource , ProductoResource, OfertaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.compra = new CompraResource(self.original);
            ProductoResource.queryAll(function(items) {
                $scope.productosSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.compra.productos){
                        $.each($scope.compra.productos, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.productosSelection.push(labelObject);
                                $scope.compra.productos.push(wrappedObject);
                            }
                        });
                        self.original.productos = $scope.compra.productos;
                    }
                    return labelObject;
                });
            });
            OfertaResource.queryAll(function(items) {
                $scope.ofertasSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.compra.ofertas){
                        $.each($scope.compra.ofertas, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.ofertasSelection.push(labelObject);
                                $scope.compra.ofertas.push(wrappedObject);
                            }
                        });
                        self.original.ofertas = $scope.compra.ofertas;
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
    
    $scope.productosSelection = $scope.productosSelection || [];
    $scope.$watch("productosSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.compra) {
            $scope.compra.productos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.compra.productos.push(collectionItem);
            });
        }
    });
    $scope.ofertasSelection = $scope.ofertasSelection || [];
    $scope.$watch("ofertasSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.compra) {
            $scope.compra.ofertas = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.compra.ofertas.push(collectionItem);
            });
        }
    });
    
    $scope.get();
});