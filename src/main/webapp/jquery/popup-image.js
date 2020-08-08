function showModel(id, image) {
    // Get the modal
    let modal = document.getElementById('image-model'+id);


    // Get the image and insert it inside the modal - use its "alt" text as a caption
    let modalImg = document.getElementById('img-cnt'+id);

    modal.style.display = "block";
    modalImg.src = image//"https://www.tikbok.com/rahalat/wp-content/uploads/2011/08/1-400x200.jpg";

    // Get the <span> element that closes the modal
    let span = document.getElementById("close"+id);

    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }
}
