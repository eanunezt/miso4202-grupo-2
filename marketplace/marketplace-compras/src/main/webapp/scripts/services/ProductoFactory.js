angular.module('marketplace-compras').factory('ProductoResource', function($resource){
    var resource = $resource('../markeplace-core/rest/productos/:ProductoId',{ProductoId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});