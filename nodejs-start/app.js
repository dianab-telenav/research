/*
 * Module dependencies
 */
var express = require('express')
  , stylus = require('stylus')
  , nib = require('nib')

var app = express()
function compile(str, path) {
  return stylus(str)
    .set('filename', path)
    .use(nib())
}
app.set('views', __dirname + '/views')
app.set('view engine', 'jade')
app.use(express.logger('dev'))
app.use(stylus.middleware(
  { src: __dirname + '/public'
  , compile: compile
  }
))
app.use(express.static(__dirname + '/public'))

app.get('/', function (req, res) {
  res.render('index',{title:'Home'})
})

var fs = require('fs')

app.get('/download', function(reeq, res){
	var file = fs.readFileSync(__dirname+'/public/images/pic.jpg','binary');
	res.setHeader('Content-type', 'image/jpeg');
	res.setHeader('Content-disposition', 'attachment; filename=pic.jpg');
	res.setHeader('Content-Length', file.length);
	res.write(file,'binary');
	res.end();

})
app.listen(3000)
