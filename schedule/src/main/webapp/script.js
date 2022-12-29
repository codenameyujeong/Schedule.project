function fn_submit(){
	var fn = document.frm;
   if(fn.Event_name ==""){
      alert("일정이름이 입력되지 않았습니다!");
      fn.M_jumin.focus();
      return false;
   }
	if(fn.Strat_date.value == ""){
		alert("일정시작 날짜가 입력되지 않았습니다.");
		fn.V_name.focus();
		return false;
	}
	if(fn.End_date.value == ""){
		alert("일정마무리 날짜가 입력되지 않았습니다.");
		fn.M_no.focus();
		return false;
	}
	if(fn.Story.value == ""){
		alert("내용이 입력되지 않았습니다.");
		fn.V_time.focus();
		return false;
	}
	fn_submit();
}