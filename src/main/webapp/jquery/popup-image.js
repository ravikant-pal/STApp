// $(document).ready(function(){
//     $('[data-toggle="popover"]').popover();
// });
/*
$(document).ready(function() {
    $('a[rel=popover]').popover({
        html: true,
        trigger: 'hover',
        placement: 'bottom',
        content: function(){return '<img src="'+$(this).data('img') + '" />';}
    });
});*/


function showModel() {
    // Get the modal
    let modal = document.getElementById("image-model");

// Get the image and insert it inside the modal - use its "alt" text as a caption
    let modalImg = document.getElementById("img-cnt");
    let captionText = document.getElementById("caption");

    modal.style.display = "block";
    modalImg.src = "https://www.tikbok.com/rahalat/wp-content/uploads/2011/08/1-400x200.jpg";
    captionText.innerHTML = "Your Image";

// Get the <span> element that closes the modal
    let span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }
}
