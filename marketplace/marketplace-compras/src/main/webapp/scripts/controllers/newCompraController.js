
angular.module('marketplace-compras').controller('NewCompraController', function ($scope, $location, locationParser, flash, CompraResource , ProductoResource, OfertaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.compra = $scope.compra || {};
    
    $scope.productoList = ProductoResource.queryAll(function(items){
        $scope.productoSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("productoSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.compra.producto = {};
            $scope.compra.producto.id = selection.value;
        }
    });
    
    $scope.ofertaList = OfertaResource.queryAll(function(items){
        $scope.ofertaSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("ofertaSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.compra.oferta = {};
            $scope.compra.oferta.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The compra was created successfully.'});
            $location.path('/Compras');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CompraResource.save($scope.compra, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Compras");
    };
});