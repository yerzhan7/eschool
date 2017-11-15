$(document).on(
		"click",
		".delete_pupil",
		function() {
			//Getting data on the pupil to delete (id, name)
			var pupilID = $(this).data('id');
			$("#modal_pupil_id").text(
					$(this).data('lastname') + ' '
					+ $(this).data('firstname'));
			$("#delete_form").attr("action", "/pupils/" + pupilID);
		});