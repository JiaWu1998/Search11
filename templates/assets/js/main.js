var config = {
    apiKey: "AIzaSyCFsC9OFfU3_VxQtE575pqxvxRkMfMi5Eg",
    authDomain: "search-eleven.firebaseapp.com",
    databaseURL: "https://search-eleven.firebaseio.com",
    projectId: "search-eleven",
    storageBucket: "search-eleven.appspot.com",
    messagingSenderId: "999597778948"
  };
  firebase.initializeApp(config);
  database = firebase.database();
  var chat = "";
  var name = '';

$('#show-button').on('click', function(){
	$('#home_login_page').fadeOut(1000);
	$('#search_page').delay(1500).fadeIn(1000);
	name = $('#name').val();
});


$('#click-me').on('click', function(){
	$('#search_page').fadeOut(1000);
	$('#progress_page').delay(1000).fadeIn(1000);
	$('#progress_page').delay(4000).fadeOut(1000);
	$('#results_page').delay(4000).fadeIn(1000);
});

	// var progress = $('#progress_bar').value();
	// // while(progress < 100) {
	// // 	progress++;

	// // 
	// // }
	// console.log(progress);


    //addOne();
//     var message = $("#search_bar_input").val();
// 	chat += message;
// 	database.ref('users/'+name).set({
// 		chat: chat 
// 	});
// 	// database.ref().set({
// 	// 	name: chat
// 	// });

// });


// function addOne() {
// 	var bar = $("#progress_bar");
//     if (bar.value < 100) { // this is the max value of the bar and the # of iterations
//         setTimeout(addOne, 80); // this literal value controls the speed
//         bar.value += 1;    
//     }else{  
//         return;
//     } 
// };




  // $(function(){
		// 	$("#send-button").on("click", function(){
		// 		console.log("Send Button Clicked");
		// 		var message = $("#search_bar_input").val();
		// 		chat += message + "<br>";
		// 		console.log(chat);
		// 		database.ref().set({
		// 			chat: chat
		// 		});
		// 	})
		// });

		// database.ref().on("value", 
		// 	function(data) {
		// 		console.log(data.val());
		// 		chat = data.val().chat;
		// 		$("#chatty").html(chat);
		// 	}, 
		// 	function(error){
		// 		console.log(error);
		// 	})