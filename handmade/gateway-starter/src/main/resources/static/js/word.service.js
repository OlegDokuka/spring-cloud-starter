(function () {
    'use strict';

    angular
        .module('sso')
        .factory('Word', Word);

    Word.$inject = ['$resource'];

    function Word ($resource) {
        return $resource('/:name/api/words', {}, {
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            }
        });
    }
})();