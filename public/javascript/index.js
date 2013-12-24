var app = app || {};

(function ($) {

    var message = Backbone.Model.extend({
        urlRoot: "/message",
        defaults: { value: "Default Hello World" }        
    });

    var messageView = Backbone.View.extend({

      el: "#content",

      messageValue: "val",

      initialize: function () {
        this.listenTo(this.model, 'change', this.render);
      },

      events: {
        "click #getMessageButton": "getMessage"
      },

      render: function () {        
        this.$el.html(_.template( $("#message_content").html(), this.model.toJSON()));
        return this;
      },

      getMessage: function() {
        this.model.fetch({
	        error: function (message) {
	            console.log(message);
	        }
        });
      }
    });

    var v = new messageView({ model: new message()});
    v.render();

})(jQuery);