
angular.module('marketplace-app').controller('NewCompraController', function ($scope, $location, locationParser, flash, CompraResource , ProductoResource, OfertaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.compra = $scope.compra || {};
    
    $scope.productosList = ProductoResource.queryAll(function(items){
        $scope.productosSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("productosSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.compra.productos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.compra.productos.push(collectionItem);
            });
        }
    });

    $scope.ofertasList = OfertaResource.queryAll(function(items){
        $scope.ofertasSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("ofertasSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.compra.ofertas = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.compra.ofertas.push(collectionItem);
            });
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