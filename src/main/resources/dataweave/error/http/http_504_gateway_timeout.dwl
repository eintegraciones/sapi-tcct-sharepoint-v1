%dw 2.0
output application/json
---
{
	code: "504",
	message: "Gateway Timeout",
	moreInformation: {
		description: error.description  as String default ""
	}
}