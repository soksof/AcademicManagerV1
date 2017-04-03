        function check(form) { /*function to check combinations of username & password*/
                var pass=form.password.value;
				var usern=form.username.value;
				if ( pass== "" || usern== "") {
					alert("Fill in both Username and Password")
					}
				else{
				/*opens Role page if Id & password matches*/
					if( usern== "secretary" &&  pass== "secretary") {
						window.open('home_secr.html')
					}
					else if (usern == "admin" && pass == "admin") {
						window.open('admin.html')
					}
					else if (usern == "student" && pass == "student") {
						window.open('home_stud.html')
					}
					else if (usern == "teacher" && pass == "teacher") {
						window.open('home_teach.html')
					}
					else {
						alert("Error Password or Username")/*displays error message*/
					}
				}
			}

	



