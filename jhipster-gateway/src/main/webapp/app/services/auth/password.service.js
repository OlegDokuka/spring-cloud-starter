(function() {
    'use strict';

    angular
        .module('gatewayApp')
        .factory('Password', Password);

    Password.$inject = ['$resource'];

    function Password($resource) {
        var service = $resource('jhipster/api/account/change_password', {}, {});

        return service;
    }
})();
