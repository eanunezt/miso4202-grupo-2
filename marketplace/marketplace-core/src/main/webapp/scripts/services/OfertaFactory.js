angular.module('marketplace-app').factory('OfertaResource', function($resource){
    var resource = $resource('rest/oferta/:OfertaId',{OfertaId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});