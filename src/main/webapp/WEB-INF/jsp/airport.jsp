<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>FlightInfo</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
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
                    <input type="submit" value="Show!">
                </form:form>
            </div>
        </div>
    </div>
    <div class="localAirport">
        <h1>${airport.nameAirport} - ${airport.codeIataAirport}</h1>
        <p>${airport.city.nameCity}, ${airport.nameCountry} (Time zone: ${airport.timezone})</p>
        <p>Local Time:  <fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${localDateTimeFormat.parse(airport.getLocalTime())}" /></p>
    </div>
    <div class="flight listHeader">
        <div class="airline">
            Airline
        </div>
        <div class="number">
            Flight Number
        </div>
        <div class="time">
            Scheduled Time
        </div>
        <div class="status">
            Flight Status
        </div>
        <div class="airport">
            Airport
        </div>
        <div class="gate">
            Gate
        </div>
        <div class="weather">
            Weather
        </div>
    </div>

    <c:forEach items="${flights}" var="flight">
        <div class="flight">

            <div class="airline">
                    ${flight.airline.name}
            </div>
            <div class="number">
                    ${flight.flight.iataNumber}
            </div>
            <div class="time">
                <fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${localDateTimeFormat.parse(flight.departure.scheduledTime)}" />
            </div>
            <div class="status">
                    ${flight.status}
                    <c:if test="${not empty flight.departure.delay}">
                        Delay: ${flight.departure.delay}
                    </c:if>
            </div>
            <div class="airport">
                    ${flight.arrAirport.codeIataAirport}, ${flight.arrAirport.city.nameCity}<br>
                    ${flight.arrAirport.nameAirport}<br>
                    ${flight.arrAirport.nameCountry}
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
</body>
</html>
