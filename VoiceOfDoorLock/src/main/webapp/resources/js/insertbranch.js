var openWin;

function getlocation() {
	window.name = "parentForm";
    // window.open("open할 window", "자식창 이름", "팝업창 옵션");
    openWin = window.open("branchmap.do", "childForm", "width=450, height=680, resizable=no, scrollbars = no");
	
}
