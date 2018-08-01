org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/customers'
        headers {
            accept(applicationJsonUtf8())
        }
    }
    response {
        status 200
        body([
                [
                    "id": $(regex(uuid())),
                    "firstName": $(consumer("Matt"), producer(regex('[a-zA-Z.-_]+'))),
                    "lastName": $(consumer("Campbell"), producer(regex('[a-zA-Z.-_]+'))),
                    "createdOn": $(consumer("2018-08-01T05:33:16+00:00"), producer(regex(iso8601WithOffset())))
                ],
                [
                    "id": $(regex(uuid())),
                    "firstName": $(consumer("Shaun"), producer(regex('[a-zA-Z.-_]+'))),
                    "lastName": $(consumer("Anderson"), producer(regex('[a-zA-Z.-_]+'))),
                    "createdOn": $(consumer("2018-08-01T06:33:16+00:00"), producer(regex(iso8601WithOffset())))
                ]
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
