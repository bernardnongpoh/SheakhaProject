SheakhaProject
==============

college Project

Geocoding

Geocoding is the process of converting addresses (like "1600 Amphitheatre Parkway, Mountain View, CA") into geographic coordinates (like latitude 37.423021 and longitude -122.083739),
which you can use to place markers or position the map. The Google Geocoding API provides a direct way to access a geocoder via an HTTP request. Additionally, the service allows you
to perform the converse operation (turning coordinates into addresses); this process is known as "reverse geocoding." 

A Geocoding API request must be of the following form:

http://maps.googleapis.com/maps/api/geocode/output?parameters

where output may be either of the following values:
json (recommended) indicates output in JavaScript Object Notation (JSON)
xml indicates output as XML

and parameters will be in this form:: "address,city,state,zip code". Here Google does not expect all address, city, state and zip you pass. If you pass only one among four it will
return you some result but then it would be difficult for you to choose an address because Google will return all possible addresses.

So its better to try to pass every parameter then it will return you exact match that you want.
Here city, state and zip code is pretty clear but some may confused what to pass in address.
address is nothing just a combination of street_number and route. As for exm: addres may be "1600 Amphitheatre Parkway" . 
