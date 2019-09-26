function getGithubInfo(user) {
    //1. Create an instance of XMLHttpRequest class and send a GET request using it. The function should finally return the object(it now contains the response!)
    var xhr = new XMLHttpRequest();
    xhr.open('GET', "https://api.github.com/users/" + user, true);
    xhr.send();
    //xhttp.onreadystatechange = function () {
    // if(xhttp.readyState === 4 && xhttp.status === 200) {
    //console.log(xhttp.responseText);
    //}
    // }

    xhr.onreadystatechange = processRequest;

    function processRequest(e) {
        console.log(xhr.readyState);

        if (xhr.readyState == 4) {

            if (xhr.status == 200) {

                var response = JSON.parse(xhr.responseText);
                //alert(response.ip);
                console.log(response);
                showUser(response);
            }
            else {
                noSuchUser(username);
            }
        }



    }

}

function showUser(user) {

    //2. set the contents of the h2 and the two div elements in the div '#profile' with the user content
    // var json = JSON.parse(xhr.responseText);
    // var yourData = json.Data;
    // document.getElementById("name").innerHTML = response.login;
    $("#name").text(user.login);
    // document.getElementById("Id").innerHTML = data.Data[0].id;
    $("#Id").text(user.id);
    //document.getElementById("profile1").innerHTML = data.Data[0].avatar_url;
    $("#profile1").text(user.avatar_url);
    //document.getElementById("link").innerHTML = data.Data[0].html_url;
    $("#link").text(user.html_url);
}

function noSuchUser(username) {
    //3. set the elements such that a suitable message is displayed
    alert("user selected is not there" + username);

}


$(document).ready(function () {
    $(document).on('keypress', '#username', function (e) {
        //check if the enter(i.e return) key is pressed
        if (e.which == 13) {
            //get what the user enters
            username = $(this).val();
            //reset the text typed in the input
            $(this).val("");
            //get the user's information and store the respsonse
            getGithubInfo(username);
            //if the response is successful show the user's details
            // if (response.status == 200) {
            //showUser(JSON.parse(response.responseText));
            //else display suitable message
        }

    })
});
