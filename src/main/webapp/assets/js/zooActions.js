/**
 * Created by Asus on 21.03.2017.
 */
// Удаление зоопарка
function removeZoo(selector) {
    selector.attr('disabled', 'true');
    var pst = {};
    pst.action = 'removeZoo';
    pst.zoo_id = selector.closest('.zoo-container').data('id');
    console.log(pst)
    $.ajax({
        type: 'POST',
        url: document.location.href,
        data: pst,
        success: function(result) {
            console.log(result)
            console.log(result.zoo_id)
            if (typeof result.error == 'undefined') {
                swal("Зоопарк удален", '', "success");
                selector.closest('.zoo-container').parent().remove();
            } else swal('Ошибка', 'Не удалось удалить запись', 'error');
            selector.removeAttr('disabled');
        },
        error: function() {swal('Ошибка', 'Не удалось отправить запрос!', 'error');}
    });
}

$(document).ready(function() {
    // Удаление зоопарка
    $(document).on('click', '.remove-zoo', function() {
        removeZoo($(this));
    });
});