(function() {
    'use strict';

    angular
        .module('JHipsterConfigServerApp')
        .factory('ConfigService', ConfigService);

    ConfigService.$inject = ['$http'];

    function ConfigService ($http) {

        var config = {
            getConfig: getConfig
        };

        return config;

        function getConfig(application, profile) {
            return $http.get('config/' + application + '-' + profile + '.yml').then(function (response) {
                return response.data;
            });
        }

    }
})();
