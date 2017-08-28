// JavaScript Document
    ////<!--  点击个人资料 开始   -->

<!--    $("#per_de").css("background","white");
-->
	
    //个人资料
    function info(){
        $("#per_de").addClass('active');
        $("#my_head").removeClass('active');
        $(".per_detail_content").show();
        $(".head_detail_content").hide();
    };

    //我的头像
   function  member(){
       $("#per_de").removeClass('active');
        $("#my_head").addClass('active');
        $(".per_detail_content").hide();
        $(".head_detail_content").show();
    };
    ////<!--  点击个人资料 结束   -->




    //显示上传图片 开始
  // 
    //    $(".stop").click(function(){
      //  $(".DB_imgSet").fadeOut(1000);
        //$(".stop").fadeOut();

    //});

    //$(".DB_thumMove").click(function(){
      //  $(this).parent().parent().next().fadeIn();

    //});


    //显示上传图片 结束


      










