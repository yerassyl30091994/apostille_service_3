app.controller('controller_p1_17', ['$scope', '$http', '$injector', '$rootScope', '$declaration', '$eds', '$robot', '$sound', '$session', '$modal', '$dictionary', '$timeout', '$filter', '$error', '$q', '$locales', '$translate',
    function ($scope, $http, $injector, $rootScope, $declaration, $eds, $robot, $sound, $session, $modal, $dictionary, $timeout, $filter, $error, $q, $locales, $translate) {


        $declaration.onLoaded(function () {
            $scope.person = {
                sppApostilledDocumentId: '',
                apostilleCode: ''
            };

            $scope.afterOk = false;
            $scope.haveTrueResult = false;


            $scope.goInputStep = function () {
                $scope.applicantIIN = null;
                $scope.applicantName = null;
                $scope.applicantSurname = null;
                $scope.applicantPatronymic = null;

                $scope.person.sppApostilledDocumentId = null;
                $scope.person.apostilleCode = null;
                $declaration.vote.voteState = null;

                $declaration.goStep('input');
            };

            $declaration.init('P1.17', {

            });


            // ---------

            // $declaration.dirtyForm = true;
            //
            // $declaration.validate = function () {
            //     if ($declaration.model.declarantUin === '' ||
            //         $declaration.model.declarantUin === null ) {
            //         $declaration.dirtyForm = true;
            //     } else {
            //         $declaration.dirtyForm = false;
            //     }
            // };
            //
            // $scope.$watch("$declaration.model.declarantUin", function () {
            //     $declaration.validate();
            // });
            //
            //
            // $declaration.loadTaxes = function () {
            //     $http.post("rest/app/send", {
            //         requestedIin:  $declaration.model.declarantUin,
            //         declarantUin: $declaration.model.declarantUin
            //     }).success(function (data) {
            //         console.log(data)
            //     }).error(function (err) {
            //         console.log(err);
            //     });
            //     $http.get("rest/culs/by-uin/"+ $declaration.model.declarantUin + '?captchaCode=' + $rootScope.captchaCode).success(function (data) {
            //         $declaration.p127Response = data;
            //         console.log(data)
            //         $declaration.goStep('query');
            //     }).error(function (err) {
            //         console.log(err);
            //     });
            // };

// -----------------------------









            $declaration.loadTaxes = function () {
                $scope.afterOk = !$scope.afterOk;
                var id = $scope.person.sppApostilledDocumentId;
                var code = $scope.person.apostilleCode;
                $http.get("rest/app/restProcess?id=" + id + "&code=" + code).success(function (rs) {
                    $scope.haveTrueResult = true;
                    $declaration.goStep('status');

                    console.log(rs);

                    $scope.applicantIIN = rs.applicant.iin;
                    $scope.applicantName = rs.applicant.name;
                    $scope.applicantSurname = rs.applicant.surname;
                    $scope.applicantPatronymic = rs.applicant.patronymic;
                }).error(function (err) {
                    $error.resetError();
                    $scope.haveTrueResult = false;
                    $declaration.goStep('status');
                });

            };



            $declaration.onStep('status', function () {
                $declaration.getCurrentState();
            });

            $declaration.allowStep('input', function () {
                return !!$declaration.requestId;
            });

            $declaration.allowStep('status', function () {
                return !!$declaration.requestId;
            });

        });



    }]);