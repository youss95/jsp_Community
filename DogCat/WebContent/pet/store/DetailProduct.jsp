<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Pet Sitting - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/animate.css">
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/magnific-popup.css">


    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/jquery.timepicker.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/style.css">
     <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
   <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
  <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  </head>
    <%@include file="../header.jsp" %>
 <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                
                 
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="<%=request.getContextPath()%>/uploadStore/${detail.fileRealName}" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${detail.name }</h5>
                                    <!-- Product reviews-->
                                    
                                   <div class="make_star">
	<select name="" id="makeStar">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
	</select>
	<div class="rating" data-rate="3">
		<i class="fas fa-star"></i>
		<i class="fas fa-star"></i>
		<i class="fas fa-star"></i>
		<i class="fas fa-star"></i>
		<i class="fas fa-star"></i>	
	</div>
</div>
  <span class="text-muted text-decoration-line-through">사이즈: ${detail.size} </span><br>
  <span class="text-muted text-decoration-line-through">색상: ${detail.color}  </span><br>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">${detail.price} 원 </span>
                                  
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/DogCat/product?cmd=addCart&pNo=${detail.productnumber}&user_no=${sessionScope.sessionUser.user_no}">Add to cart</a>
                                <a href="/DogCat/product?cmd=detail&pNo=${detail.productnumber }" class="btn btn-primary ">Detail</a>
                                </div>
                            </div>
                        </div>
                    </div>
                  
                
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script>
        $(function(){


            let rating = $('.review .rating');
            rating.each(function(){
                let targetScore = $(this).attr('data-rate');
                $(this).find('i:nth-child(-n'+targetScore+')').css({color:'yellow'})
            });

            let userScore = $('#makeStar');
            userScore.change(function(){
                //change()는 해당하는 요소의 value에 변화가 생길 경우 이를 감지해 등록된 콜백함수를 동작
                // select 태그에 많이 씀
                //select 값이 바뀌면 바뀐값이 나타나게됨
                let userScoreNum = $(this).val();    //바뀐값
                console.log(userScoreNum);
                $('.make_star i').css({color:'#000'});
                $(".make_star").find('.rating').find('i:nth-child(-n'+userScoreNum+')').css({color:'yellow'})
            });
            $('.make_star i').click(function(){
                let targetNum = $(this).index()+1;  //0,1,2 로 시작하니까
                $('.make_star i').css({color:'#000'});
                $(".make_star").find('.rating').find('i:nth-child(-n'+targetNum+')').css({color:'yellow'})
            })
        });
        </script>
        <script src="<%=request.getContextPath()%>js/scripts.js"></script>
</body>
</html>