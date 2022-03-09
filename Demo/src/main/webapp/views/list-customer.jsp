<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customer</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<c:url value="/" var="rootpath" />
<body class="text-center my-3">

	<h1 class="my-3 text-center text-danger">
		<a href="${rootpath}customer">HR - Manager</a>
	</h1>

	<a href="${rootpath}add" class="btn btn-success my-3" type="submit">Add
		new 🤑</a>

	<div class="container">
		<div class="row my-2">
			<div class="col-md-6 mx-auto">
				<form class="text-start">
					<div class="mt-3">
						<label for="search-name" class="form-label">Gender: </label> <input
							id="search-name" type="text" name="s_name" value="${s_name}"
							class="form-control" placeholder="Name ...">
					</div>

					<div class="mt-3">
						<label for="order" class="form-label">Order By: </label> <select
							id="order" class="form-select" name="order_by">
							<option value="ASC" ${order_by == 'ASC' ? 'selected' : ''}>ASC</option>
							<option value="DESC" ${order_by == 'DESC' ? 'selected' : ''}>DESC</option>
						</select>
					</div>

					<div class="mt-3">
						<label for="gender" class="form-label">Order By: </label> <select
							id="gender" class="form-select" id="s_gender" name="s_gender">
							<option value="1" ${s_gender == 1 ? 'selected' : ''}>Male</option>
							<option value="0" ${s_gender == 0 ? 'selected' : ''}>Female</option>
						</select>
					</div>

					<div class="d-grid gap-4 col-6 mx-auto d-flex">
						<button class="btn btn-outline-info btn-lg my-3" type="submit">Search</button>
						<button class="btn btn-outline-danger btn-lg my-3" type="reset">Clear</button>
					</div>
				</form>
			</div>
		</div>

		<c:if test="${info != null}">
			<div class="alert alert-info alert-dismissible fade show my-3"
				role="alert">
				<strong>${info}</strong>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<div class="row">

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Gender</th>
						<th scope="col">Birthday</th>
						<th scope="col">HomeTown</th>
						<th scope="col">Email</th>
						<th scope="col">Phone</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listCus}" var="customer">
						<tr>
							<th scope="row">${customer.id}</th>
							<td>${customer.name}</td>
							<td>${customer.gender ? "Male" : "Female"}</td>
							<td>${customer.birthday}</td>
							<td>${customer.hometown}</td>
							<td>${customer.email}</td>
							<td>${customer.phone}</td>
							<td><a class="btn btn-warning"
								href="${rootpath}edit?id=${customer.id}" class="text-black">
									Edit</a> <a
								onclick="return confirm('Are you sure removere item via id: ${customer.id}')"
								class="btn btn-danger"
								href="${rootpath}delete?id=${customer.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>