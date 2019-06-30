var gulp = require('gulp');
var rename = require("gulp-rename");
var concat = require('gulp-concat');
var uglifyjs = require('uglify-js'); // can be a git checkout
                                     // or another module (such as `uglify-es` for ES6 support)
var composer = require('gulp-uglify/composer');
var pump = require('pump');
 
var minify = composer(uglifyjs, console);
 
gulp.task('compress', function (cb) {
  // the same options as described above
  var options = {
    compress:true,
    mangle:true
  };
 
  pump([
      gulp.src('dev/**/*.js'),
      concat("main.js"),
      minify(options),
      rename({ suffix: '.min' }),
      gulp.dest('prod')
    ],
    cb
  );
});