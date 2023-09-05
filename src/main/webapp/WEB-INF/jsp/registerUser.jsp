<!DOCTYPE html>
<html>
<body>

<h2>HTML Forms</h2>

<p>save user</p>
<form method = "POST" action = "savedUser">
  <label for="name">First name:</label><br>
  <input type="text" id="name" name="name"><br>
  <input type="submit" value="Submit">
</form>

<br>
<br>

<p>get user</p>
<form method = "GET" action = "getUser">
  <label for="id">Enter Id: </label><br>
  <input type="text" id="id" name="id"><br>
  <input type="submit" value="Submit">
</form>

<br>
<br>

<p>delete user</p>
<form method = "POST" action = "deleteUser">
  <label for="delete">Enter Id: </label><br>
  <input type="text" id="id" name="id"><br>
  <input type="submit" value="Submit">
</form>

<br>
<br>

<p>update user</p>
<form method = "POST" action = "updateUser">
  <label for="id">Enter Id: </label><br>
  <input type="text" id="id" name="id"><br>
  <label for="name">Enter Id: </label><br>
  <input type="text" id="name" name="name"><br>
  <input type="submit" value="Submit">
</form>

<br>
<br>

</body>
</html>