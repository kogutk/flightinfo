<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>FlightInfo</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/fontawesome-free-5.13.1-web/css/all.css"/>" rel="stylesheet">
</head>
<body>
    <style>
        body {
            background-image: url("<c:url value="/img/flightbig3.jpg" />"), url("<c:url value="/img/flightbig3bottom.jpg" />");
            background-repeat: no-repeat, repeat;
            background-position: center top;
            background-size: auto;
        }
    </style>
    <div class="header">
        <div class="logo">
            <h1>FlightInfo App</h1>
        </div>
        <div class="menu">
            <div class="menuItem">
                <a href="airport">My Airport</a>
            </div>
            <div class="menuItem">
                <form:form modelAttribute="airport">
                    Airport: <form:input path="codeIataAirport"></form:input>
                    <button type="submit"><i class="fa fa-search fa-rotate-90" aria-hidden="true"></i></button>
                </form:form>
            </div>
        </div>
    </div>
    <c:if test="${not empty errorMessage}">
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            ${errorMessage}
        </div>
    </c:if>

    <div class="localAirport">
        <h1>${airport.nameAirport} - ${airport.codeIataAirport}</h1>
        <p>${airport.city.nameCity}, ${airport.nameCountry} (Time zone: ${airport.timezone})</p>
        <p>Local Time:  <fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${localDateTimeFormat.parse(airport.getLocalTime())}" /></p>
    </div>
    <div class="flight listHeader">
        <div class="number">
            Flight Number
        </div>
        <div class="destination">
            Destination
        </div>
        <div class="time">
            Time
        </div>
        <div class="airline">
            Airline
        </div>
        <div class="status">
            Flight Status
        </div>
        <div class="gate">
            Gate
        </div>
        <div class="weather">
            Weather
        </div>
    </div>

    <c:forEach items="${flights}" var="flight">
        <div class="flight <c:if test="${flight.newStatus eq 'delayed'}"> delayed</c:if>">
            <div class="number">
                    ${flight.flight.iataNumber}
            </div>
            <div class="destination">
                    ${flight.arrAirport.city.nameCity}, ${flight.arrAirport.codeIataAirport}<br/>
                    ${flight.arrAirport.nameCountry}
            </div>
            <div class="time">
                <c:if test="${empty flight.departure.delay}">
                    <fmt:formatDate pattern = "HH:mm" value = "${localDateTimeFormat.parse(flight.departure.scheduledTime)}" />
                </c:if>
                <c:if test="${not empty flight.departure.delay}">
                    <fmt:formatDate pattern = "HH:mm" value = "${localDateTimeFormat.parse(flight.departure.estimatedTime)}" />
                        <br/>(Sch.: <fmt:formatDate pattern = "HH:mm" value = "${localDateTimeFormat.parse(flight.departure.scheduledTime)}" />)
                </c:if>
            </div>
            <div class="airline">
                    <img alt="${flight.airline.name}" title="${flight.airline.name}" src="https://daisycon.io/images/airline/?width=80&height=40&iata=${flight.airline.iataCode}">
<%--                    ${flight.airline.name}--%>
            </div>
            <div class="status">
                    ${flight.newStatus}<c:if test="${flight.newStatus eq 'delayed'}">: ${flight.departure.delay}</c:if>
            </div>
            <div class="gate">
                    ${flight.departure.gate}
            </div>
            <div class="weather">
                <fmt:parseNumber var="temp" integerOnly="true" type="number" value="${flight.arrWeather.main.temp} " />
                <p>${temp}&#8451</p>
                <img src="http://openweathermap.org/img/w/${flight.arrWeather.weatherDescs[0].icon}.png">
            </div>
        </div>
    </c:forEach>
<div class="footer">
    Copyrights kkogut, WWSIS, 2020
</div>
</body>
</html>
