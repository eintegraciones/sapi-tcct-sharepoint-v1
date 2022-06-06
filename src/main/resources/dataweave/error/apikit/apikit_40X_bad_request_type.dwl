%dw 2.0
import * from dw::core::Strings
output application/json
var msg = error.description default ""
var authRequired = msg matches("^Required header 'Authorization' not specified\$")
---
if (authRequired)
{
	code: 401,
	message: msg
}
else 
{
	code: 400,
	message: msg
}