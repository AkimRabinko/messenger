let messenger = angular.module("messenger", []);
messenger.controller("mainController", ['$scope', '$http', function ($scope, $http) {
    $scope.options = [
        {
            id: 1,
            link: '/',
            text: 'Home'
        }, {
            id: 2,
            link: '/news',
            text: 'Latest News'
        }, {
            id: 3,
            link: '/info',
            text: 'Information'
        }, {
            id: 4,
            link: '/notifications',
            text: 'Notifications Bar'
        }, {
            id: 5,
            link: '/messages',
            text: 'Private Messages'
        }
    ];

}]);