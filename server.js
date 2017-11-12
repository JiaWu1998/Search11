var express = require('express')
, router = express.Router()
  , multer = require('multer');
var app = express();
var server = require('http'). createServer(app);
var io = require('socket.io').listen(server);
const util = require('util');

users = [];
connections = [];


server.listen(process.env.PORT || 3000);
console.log('Server Running');
console.log(__dirname)
  

// var uploading = multer({
//   dest: __dirname + '/public/assets/uploadedImages/',
// });

// router.post('public/assets/uploadedImages/', uploading, function(req, res) {

// })


app.use(express.static("public"));
// app.get('/', function(req, res) {
// 	res.sendFile(__dirname + '/index.html');	
// });

io.sockets.on('connection', function(socket) {
	connections.push(socket);
	console.log('Connected: %s sockets connected', connections.length);
	
	//disconnect
	socket.on('disconnect', function(data){
		// remove user from color object
		
		users.splice(users.indexOf(socket.username), 1);
		connections.splice(connections.indexOf(socket), 1);
		console.log('Disconnected: %s sockets connected', connections.length);
	});

	// Send Message
	// socket.on('send message', function(data) {
	// 	console.log(data);
	// 	io.sockets.emit('new message', {msg: data, user: socket.username/*, color: colors[socket.username]*/});
	// });

	// New User
	socket.on('new user', function(data, callback){
		callback(true);
		socket.username = data;
		users.push(socket.username);
		// get random color
		// colors[socket.username] = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')'
		// console.log(`COLORS: ${colors[socket.username]}`)
		updateUsernames();
	});

	function updateUsernames() {
		io.sockets.emit('get users', users);
	};
});

module.exports = users;

module.exports = router