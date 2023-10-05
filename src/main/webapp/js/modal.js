$(document).ready(function () {
    // Open the modal
    function openModal(target) {
        console.log('openModal', target)
        $(`${target}, #overlay`).fadeIn();
    }
    // foreach #openModalBtn add click event
    // $("#openModalBtn").click(function () {
    //     openModal("#myModal");
    // })
    const openBtns = document.querySelectorAll('#openModalBtn')??[];
    openBtns?.forEach(btn => {
        btn.addEventListener('click', function () {
            openModal("#myModal");
        })
    })

    // Close the modal
    $(".close, #overlay, .cancel").click(function () {
        $("#myModal, #overlay").fadeOut();
    });
});
