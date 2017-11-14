angular.module('marketplace-app').factory('ProductoResource', function($resource){
    var resource = $resource('rest/productos/:ProductoId',{ProductoId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});