<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header id="landingPage"
		style="background-image: url('image/room${selectCategory}.jpg'); height: 50vh;">
		<div class="landingPageContent">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-12 col-12">
						<h2>
							<c:if test="${selectCategory == 0 || empty selectCategory}">
							All products
							</c:if>
							${categoryName}
						</h2>

					</div>
				</div>
			</div>
		</div>
	</header>