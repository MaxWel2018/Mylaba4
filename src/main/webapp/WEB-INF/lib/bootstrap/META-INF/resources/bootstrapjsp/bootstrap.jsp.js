/*
 * Support for data-forward attribute
 * 
 * A value of "click=close" would trigger a "close" event on
 * the element when it receives a "click" event. Multiple forwards
 * can be separated by commas.
 */
$(document).bind('ready DOMNodeInserted', function (e) {
    var forwarded = $(e.target).find('[data-forward]');
    $.each(forwarded, function () {
        var element = $(this), forwards = element.attr('data-forward');
        $.each(forwards.split(','), function () {
            /*
            var forward = this.split('=');
            element.on(forward[0], function(event) {
                element.trigger({type:forward[1], originalEvent:event});
            });
            */
            var f2 = this.split(/([>=<])/), backward = f2[1] == '<', source = backward ? $(document) : element;
            if (backward && f2[0] == 'ready') {
                element.trigger({type: f2[2], originalEvent: event});
            } else {
                source.on(f2[0], function (event) {
                    element.trigger({type: f2[2], originalEvent: event});
                });
            }
        });
    });
});
