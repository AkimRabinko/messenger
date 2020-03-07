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

    $scope.articles = [];

    $scope.fillData = function () {
        $('.main-body').css('height', ($(window).height() - 110) + 'px');
        for (let i = 0; i < 5; i++) {
            $scope.articles.push({
                name: 'Test',
                tags: ['test', 'test', 'test'],
                creationDate: '2020-03-07 12:54',
                mainText: '"Content" is used here as as term instead of "text", ' +
                    'because while text-align certainly affects text, it affects all ' +
                    'inline or inline-block elements in that container. ' +
                    'There are two new values in CSS3 as well, start and end. ' +
                    'These values make multiple language support easier For example, ' +
                    'English is a left-to-right (ltr) language and Arabic is a right-to-left (rtl) language. ' +
                    'Using "right" and "left" for values is too rigid and doesn\'t adapt as the direction changes. ' +
                    'These new values do adapt:'
            });
        }
    }
}]);