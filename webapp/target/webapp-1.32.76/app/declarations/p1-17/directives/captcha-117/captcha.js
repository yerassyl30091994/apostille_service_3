angular.module("app").directive("captcha117", ['$http', '$dictionary', '$declaration', '$locales', '$rootScope', '$robot', '$error',
    function ($http, $dictionary, $declaration, $locales, $rootScope, $robot, $error) {
        return {
            scope: {
                disable: '=',
                callback: '='
            },
            replace: true,
            restrict: 'E',
            transclude: true,
            templateUrl: "app/declarations/p1-17/directives/captcha-117/captcha.html",
            link: function (scope, elm, attrs) {

                var callback = scope.callback || function(){
                    console.log("nothing");
                };

                updateCaptcha();

                scope.checkCaptchaAndGoToStep = function () {
                    var params = {'captchaCode': scope.code};
                    $http.post('rest/captcha/check-captcha', params)
                        .success(function (data) {
                            if ((data.rightCaptcha)) {
                                $error.resetError();
                                updateCaptcha();
                                $rootScope.captchaCode = scope.code;
                                // callback();
                                $declaration.loadTaxes();
                            } else {
                                $error.setError('captcha.error.incorrectcaptcha');
                                updateCaptcha();
                            }
                        }).error(function (rs, status) {
                        $error.setError('captcha.error.serverError');
                        // updateCaptcha();
                    });
                    $("#input_captcha").val("");
                };

                scope.updateCaptchaCode = function(){
                    updateCaptcha();
                };

                function updateCaptcha(){
                   d = new Date();
                    $("#captcha_picture").attr("src", "captcha?"+ d.getTime());
                }
            }
        }
    }]);
