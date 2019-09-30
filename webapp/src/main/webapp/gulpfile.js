var gulp = require('gulp');
var less = require('gulp-less');
var concat = require('gulp-concat');
var minifyCSS = require('gulp-minify-css');
var autoprefixer = require('gulp-autoprefixer');
var extend = require('gulp-extend');
var wrap = require('gulp-wrap');
var angularTemplates = require('gulp-angular-templatecache');
var uglify = require('gulp-uglify');
var cssBase64 = require('gulp-css-base64');
var inline_image_path = require('gulp-inline-image-path');
var lib = require('bower-files')();
var fs = require('fs');
var dformat = require('dateformat');
var pinfo = require('./package.json');
var finfo = require('./node_modules/egov-pep-frontend/package.json');

/* rubricator icons */
gulp.task('ricons', function() {
    return gulp.src(['app/rubricator/css/img/*.*']).pipe(gulp.dest("build/icons"));
});
/* rubricator icons */
gulp.task('ricons-contrast', function() {
    return gulp.src(['app/rubricator/css/img/contrast/*.*']).pipe(gulp.dest("build/icons/contrast"));
});
/* rubricator icons */
gulp.task('ricons-contrast-black', function() {
    return gulp.src(['app/rubricator/css/img/contrast-black/*.*']).pipe(gulp.dest("build/icons/contrast-black"));
});
/* perfomance txt files */
gulp.task('perf', function() {
    return gulp.src(['node_modules/egov-pep-frontend/framework/angular/misc/*.txt'])
    .pipe(gulp.dest("build/perf/"));
});

/* favicon */
gulp.task('favicon', function() {
    return gulp.src(['node_modules/egov-pep-frontend/favicon.ico'])
    .pipe(gulp.dest("./"));
});

/* fonts */
gulp.task('fonts', function() {
    return gulp.src([
        'node_modules/egov-pep-frontend/kit/_styles/fonts.css',
        'node_modules/egov-pep-frontend/kit/_styles/fonts/*.woff',
        'node_modules/egov-pep-frontend/kit/_styles/fonts/*.ttf'])
        .pipe(gulp.dest("build/fonts"));
});

/* inline images */
gulp.task('imgs', function() {
    return gulp.src([
        "node_modules/egov-pep-frontend/kit/_styles/images/icons/icon-status-fail-animated.gif",
        "node_modules/egov-pep-frontend/kit/_styles/images/icons/icon-status-ok-animated.gif",
        "node_modules/egov-pep-frontend/kit/_styles/images/icons/icon-pdf.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/icons/icon-pdf-small.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/icons/icon-status-warning-animated.gif",
        "node_modules/egov-pep-frontend/kit/_styles/images/icons/clock-animated.gif",
        "node_modules/egov-pep-frontend/kit/_styles/images/pep/icons/icon-flash-animated.gif",
        "node_modules/egov-pep-frontend/kit/_styles/images/pep/icons/icon-kaztoken-animated.gif",
        "node_modules/egov-pep-frontend/kit/_styles/images/pep/icons/icon-identity-animated.gif",
        "node_modules/egov-pep-frontend/kit/_styles/images/bg_pattern.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/pep/icon-search.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/contrast/eye.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/contrast/eye-light.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/contrast/contrast.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/contrast/contrast-light.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/icon-contrast-pep.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/fb.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/tw.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/gp.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/vk.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/em.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/fe.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/logo.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/eye.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/user_white.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/user_arrow.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/arrow.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/exit.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/search.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/favs.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/user.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/new_design/phone.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/sign.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/pep/document.png",
        "node_modules/egov-pep-frontend/kit/_styles/images/icons/icon-refresh.png"
    ])
    .pipe(gulp.dest("build/images"));
});

// templates cache
gulp.task('dhtml', function () {
    return gulp.src('node_modules/egov-pep-frontend/kit/directives/**/*.html')
        .pipe(inline_image_path({path:"build/images"}))
        .pipe(angularTemplates({
            module: 'app',
            root: 'kit/directives',
            filename: 'dhtml.js'
        }))
        .pipe(gulp.dest('node_modules/egov-pep-frontend/build/'));
});

gulp.task('html', function () {
    return gulp.src([
        'node_modules/egov-pep-frontend/app/declarations/**/*.html',
        'app/declarations/**/*.html'
    ])
        .pipe(inline_image_path({path:"build/images"}))
        .pipe(angularTemplates({
            module: 'app',
            root: 'app/declarations',
            filename: 'html.js'
        }))
        .pipe(gulp.dest('node_modules/egov-pep-frontend/build/'));
});

gulp.task('rubricator-html', function () {
    return gulp.src([
        'app/rubricator/*.html'
    ])
        .pipe(angularTemplates({
            module: 'app',
            root: 'app/rubricator',
            filename: 'rubricator-html.js'
        }))
        .pipe(gulp.dest('node_modules/egov-pep-frontend/build/'));
});

/* locale constants */
gulp.task('locale-en', function() {
    return gulp.src([
        'node_modules/egov-pep-frontend/kit/**/en.json',
        'node_modules/egov-pep-frontend/app/**/en.json',
        'app/**/en.json',
        'node_modules/egov-pep-frontend/i18n/**/en.json'
    ])
        .pipe(extend('i18n.en.js'))
        .pipe(wrap('app.constant(\'i18n_en\',<%= contents %>);'))
        .pipe(gulp.dest("node_modules/egov-pep-frontend/kit/vars/"));
});

gulp.task('locale-ru', function() {
    return  gulp.src([
        'node_modules/egov-pep-frontend/kit/**/ru.json',
        'node_modules/egov-pep-frontend/app/**/ru.json',
        'app/**/ru.json',
        'node_modules/egov-pep-frontend/i18n/**/ru.json'
    ])
        .pipe(extend('i18n.ru.js'))
        .pipe(wrap('app.constant(\'i18n_ru\',<%= contents %>);'))
        .pipe(gulp.dest("node_modules/egov-pep-frontend/kit/vars/"));
});

gulp.task('locale-kk', function() {
    return gulp.src([
        'node_modules/egov-pep-frontend/kit/**/kz.json',
        'node_modules/egov-pep-frontend/app/**/kz.json',
        'app/**/kz.json',
        'node_modules/egov-pep-frontend/i18n/**/kz.json'
    ])
        .pipe(extend('i18n.kz.js'))
        .pipe(wrap('app.constant(\'i18n_kz\',<%= contents %>);'))
        .pipe(gulp.dest("node_modules/egov-pep-frontend/kit/vars/"));
});

// all-in apps
gulp.task('declarations', function() {
    return gulp.src([
        'node_modules/egov-pep-frontend/app/**/*.js',
        'app/**/*.js'
    ])
        .pipe(concat('declarations.js'))
        .pipe(uglify({mangle: false}))
        .pipe(gulp.dest('node_modules/egov-pep-frontend/build/'));
});

gulp.task('config', function() {
    return gulp.src([
        'app/declarations/**/config.json'
    ])
        .pipe(extend('config.js'))
        .pipe(wrap(function(file){return 'angular.module(\"app\").constant(\'declarations_config\', {\"' + JSON.parse(file.contents.toString()).code + '\":<%= contents %>});angular.module("app").constant("rubricator_config", {});';}))
        .pipe(gulp.dest("node_modules/egov-pep-frontend/kit/vars/"));
});

// all-in directives and services
gulp.task('components', ['locale-en', 'locale-ru', 'locale-kk', 'config'], function() {
    return gulp.src([
        'node_modules/egov-pep-frontend/kit/**/*.js',
        '!node_modules/egov-pep-frontend/kit/vars/declarations-config.js'
    ])
        .pipe(concat('components.js'))
        .pipe(uglify({ mangle: false }))
        .pipe(gulp.dest('node_modules/egov-pep-frontend/build/'));
});

// all-in libs
gulp.task('vendors', function(){
    var bowerfiles = lib.ext('js').files;
    var libs = [
        "node_modules/egov-pep-frontend/framework/bower_components/jqueryui/ui/i18n/jquery.ui.datepicker-ru.js",
        "node_modules/egov-pep-frontend/framework/bower_components/jqueryui/ui/i18n/jquery.ui.datepicker-kz.js",
        "node_modules/egov-pep-frontend/framework/bower_components/jqueryui/ui/i18n/jquery.ui.datepicker-en.js",
        "node_modules/egov-pep-frontend/framework/angular/angular-ui/angular-ui-ieshiv.js",
        "node_modules/egov-pep-frontend/framework/angular/angular-ui/angular-ui.js"
    ];
    libs = bowerfiles.concat(libs);
    return gulp.src(libs)
        .pipe(concat('vendors.js'))
        .pipe(uglify({mangle: false}))
        .pipe(gulp.dest('node_modules/egov-pep-frontend/build/'));
});

// all-in main modules
gulp.task('app', function() {
    return gulp.src('node_modules/egov-pep-frontend/framework/angular/**/*.js')
        .pipe(concat('app.js'))
        .pipe(uglify({mangle: false}))
        .pipe(gulp.dest('node_modules/egov-pep-frontend/build/'));
});

// all-in css
gulp.task('build-less', function() {
    return  gulp.src([
        'node_modules/egov-pep-frontend/kit/_styles/mixins.less',
        'node_modules/egov-pep-frontend/kit/_styles/variables.less',
        'node_modules/egov-pep-frontend/kit/_styles/pod/pod_variables.less',
        'node_modules/egov-pep-frontend/kit/_styles/pep/pep_variables.less',
        'node_modules/egov-pep-frontend/kit/_styles/core.less',
        'node_modules/egov-pep-frontend/kit/_styles/controls.less',
        'node_modules/egov-pep-frontend/kit/_styles/pep/pep_controls.less',
        'node_modules/egov-pep-frontend/kit/_styles/datepicker.less',
        'node_modules/egov-pep-frontend/kit/_styles/components.less',
        'node_modules/egov-pep-frontend/kit/_styles/main.less',
        'node_modules/egov-pep-frontend/kit/_styles/_page-overrides.less',
        'node_modules/egov-pep-frontend/kit/_styles/adaptivity.less',
        'node_modules/egov-pep-frontend/kit/_styles/contrast-view.less',
        'node_modules/egov-pep-frontend/kit/_styles/contrast-pep-view.less',
        'node_modules/egov-pep-frontend/kit/_styles/contrast-view-light.less',
        'node_modules/egov-pep-frontend/kit/_styles/contrast-pep-view-light.less',
        'node_modules/egov-pep-frontend/kit/_styles/pod/pod.less',
        'node_modules/egov-pep-frontend/kit/_styles/pep/pep.less',
        'node_modules/egov-pep-frontend/framework/**/*.less',
        'node_modules/egov-pep-frontend/kit/directives/**/*.less',
        'node_modules/egov-pep-frontend/app/**/*.less',
        'app/**/*.less'
    ])
        .pipe(concat('build.less'))
        .pipe(less())
        .pipe(gulp.dest('node_modules/egov-pep-frontend/kit/_styles/'));
});

gulp.task('build-css', ['build-less'], function(){
    return gulp.src([
        "node_modules/egov-pep-frontend/kit/_styles/build.css",
        "node_modules/egov-pep-frontend/framework/angular/angular-ui/angular-ui.css",
        "node_modules/egov-pep-frontend/framework/angular/angular-csp.css"
    ])
        .pipe(cssBase64({
            maxWeightResource: 1000000
        }))
        .pipe(concat('build.css'))
        .pipe(autoprefixer('last 10 versions', 'ie 9'))
        .pipe(minifyCSS({keepBreaks: false}))
        .pipe(gulp.dest('build/'));
});

// all-in main modules
gulp.task('build-js', [ 'vendors', 'app', 'declarations', 'components', 'html', 'rubricator-html', 'dhtml' ],function() {
    return gulp.src([
        'node_modules/egov-pep-frontend/build/vendors.js',
        'node_modules/egov-pep-frontend/build/app.js',
        'node_modules/egov-pep-frontend/build/html.js',
        'node_modules/egov-pep-frontend/build/dhtml.js',
        'node_modules/egov-pep-frontend/build/rubricator-html.js',
        'node_modules/egov-pep-frontend/build/components.js',
        'node_modules/egov-pep-frontend/build/declarations.js'
    ])
        .pipe(concat('build.js'))
        .pipe(gulp.dest('build/'));
});

gulp.task('build', ['build-js', 'build-css', 'fonts', 'imgs', 'favicon', 'perf', 'ricons', 'ricons-contrast', 'ricons-contrast-black'], function(){
    var d = new Date();
    var builat = dformat(d, "dd.mm HH:MM");
    var prefix = "?v=" + d.getTime();
    var css = [ "build" ];
    var js = [ "build" ];

    return fs.readFile('./node_modules/egov-pep-frontend/kit/index.tpl', 'utf8', function (err,data) {
        if (err) return console.log(err); var cssTpl = '', jsTpl = '';
        for(var file in css) cssTpl += '<link rel="stylesheet" type="text/css" href="build/'+ css[file] +'.css' + prefix + '">';
        for(var file in js) jsTpl += '<script src="build/'+ js[file] +'.js' + prefix + '"></script>';

        var result = data.replace("<build info/>",  pinfo.name + ' v' + pinfo.version + ' @ '+ builat)
            .replace("<frontend/>", finfo.version)
            .replace("<css assets/>", cssTpl)
            .replace("<js assets/>", jsTpl);

        fs.writeFile('./index.html', result, 'utf8', function (err) {
            if (err) return console.log(err)
            else console.log("build success " + builat);
        });
    });
});
