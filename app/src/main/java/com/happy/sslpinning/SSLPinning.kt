import okhttp3.CertificatePinner

// Define your server's hostname
val serverHostname = "test3.maxvalue.co.in"

// Load the SSL certificate from the assets folder
val certificatePinner = CertificatePinner.Builder()
    .add(serverHostname, "sha256/MIIGNjCCBR6gAwIBAgIJAMMPdHTC7eM5MA0GCSqGSIb3DQEBCwUAMGYxCzAJBgNV\\n\" +\n" +
            "                    \"BAYTAklOMRMwEQYDVQQLEwplbVNpZ24gUEtJMSUwIwYDVQQKExxlTXVkaHJhIFRl\\n\" +\n" +
            "                    \"Y2hub2xvZ2llcyBMaW1pdGVkMRswGQYDVQQDExJlbVNpZ24gU1NMIENBIC0gRzEw\\n\" +\n" +
            "                    \"HhcNMjQwMzIzMjMyMDA1WhcNMjUwNDE3MjMyMDA1WjAbMRkwFwYDVQQDDBAqLm1h\\n\" +\n" +
            "                    \"eHZhbHVlLmNvLmluMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4WZT\\n\" +\n" +
            "                    \"HPjYobdTvUKCw5glC2BMSQov/o6r7kFVxgJhLOcagaMmo8eB9y0GWdjMyu1N2Tjy\\n\" +\n" +
            "                    \"MVZ8MMWscsSsbv6/Pn787laa+0Eu6oBLqv1Jvl90Omrwf590yeVxj5x6k4g6+Asp\\n\" +\n" +
            "                    \"AXtSWwcawdmAfqZD98w6Z1b6wVCMVmXQsPwkuxakO2j1DsAggf2fGCU06Z4PeB9w\\n\" +\n" +
            "                    \"Gk7tBmuoxnTz7DQBp2m/ZsC8icuJmCg1VlPIrrgk1GYjjqddFACOMKrwVQc8k+fi\\n\" +\n" +
            "                    \"5vsE05rFhuLyI7pmLTvaBmpoElT4mhWxWIOVDBsRfsZZ63grRGQSGEM9M3LLcyQ+\\n\" +\n" +
            "                    \"+xp9Qo/afyYE2rbNLQIDAQABo4IDMDCCAywwHwYDVR0jBBgwFoAUNNH3OTJFQEqZ\\n\" +\n" +
            "                    \"K32JaldprZWv4zcwHQYDVR0OBBYEFI1mqOjkXUTF3jQJB+h44Lxyr/e6MB0GA1Ud\\n\" +\n" +
            "                    \"JQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjBOBgNVHSAERzBFMDkGCysGAQQBg44h\\n\" +\n" +
            "                    \"AQABMCowKAYIKwYBBQUHAgEWHGh0dHA6Ly9yZXBvc2l0b3J5LmVtU2lnbi5jb20w\\n\" +\n" +
            "                    \"CAYGZ4EMAQIBMHQGCCsGAQUFBwEBBGgwZjAiBggrBgEFBQcwAYYWaHR0cDovL29j\\n\" +\n" +
            "                    \"c3AuZW1TaWduLmNvbTBABggrBgEFBQcwAoY0aHR0cDovL3JlcG9zaXRvcnkuZW1z\\n\" +\n" +
            "                    \"aWduLmNvbS9jZXJ0cy9lbVNpZ25TU0xDQUcxLmNydDA4BgNVHR8EMTAvMC2gK6Ap\\n\" +\n" +
            "                    \"hidodHRwOi8vY3JsLmVtc2lnbi5jb20/ZW1TaWduU1NMQ0FHMS5jcmwwKwYDVR0R\\n\" +\n" +
            "                    \"BCQwIoIObWF4dmFsdWUuY28uaW6CECoubWF4dmFsdWUuY28uaW4wDgYDVR0PAQH/\\n\" +\n" +
            "                    \"BAQDAgWgMAwGA1UdEwEB/wQCMAAwggF+BgorBgEEAdZ5AgQCBIIBbgSCAWoBaAB1\\n\" +\n" +
            "                    \"AE51oydcmhDDOFts1N8/Uusd8OCOG41pwLH6ZLFimjnfAAABjm2dWnAAAAQDAEYw\\n\" +\n" +
            "                    \"RAIgcKF9x/H+AQwyXe9QsQF3T6YlrX6iEakLf2dr+V6kKnsCIBLgZooBZ4cv7NWO\\n\" +\n" +
            "                    \"EZe5rSHpk9d5KoXmVZ7sNPDcOBiKAHcAzPsPaoVxCWX+lZtTzumyfCLphVwNl422\\n\" +\n" +
            "                    \"qX5UwP5MDbAAAAGObZ1fCQAABAMASDBGAiEAwE2O8jZK2Zl//mHcnGHOimFELdan\\n\" +\n" +
            "                    \"xwjuJjAVD1MCBoQCIQDQ5TTD75K+UnGknDH56pJAoSGsxm4tSLRq0NP/NNR1SQB2\\n\" +\n" +
            "                    \"AKLjCuRF772tm3447Udnd1PXgluElNcrXhssxLlQpEfnAAABjm2dY6MAAAQDAEcw\\n\" +\n" +
            "                    \"RQIgLcLfpMydJ3+TTB289YwN1IvsoGDQ0EBwxUMq+YVbPTACIQC0V5cBrugabYrF\\n\" +\n" +
            "                    \"Iptue0YwN6CiP2SIK/LWD4wY5fTiuzANBgkqhkiG9w0BAQsFAAOCAQEAOIyN/G0A\\n\" +\n" +
            "                    \"OHdyLuujzwpI43DsjMP6Lw7IpUodhOsky//3VDgeWIBhQHM2A6GMRW398OPennzt\\n\" +\n" +
            "                    \"9hp5TTtrSeCcBeaxKDUPFauCxqwJ5x8GcO27F5NUZHJp9+FmyOqFT/XhbzsFwqlZ\\n\" +\n" +
            "                    \"X49UyuuiBccBnQ9YgEhMteD6VYX/ThGd2ZLfN+qM79NIcK6OPB2Y2ecGcLGCN39/\\n\" +\n" +
            "                    \"chaKxSqt5A/4zJ6Tt8jbOyZDOZ18ZAzlUu+PawAYb2TzxV+IG+KTC6uIsrNHeTAW\\n\" +\n" +
            "                    \"U2YGets3JMDYZJLO8qDyyDEyEgUlKiwLmuNPV7O9m38SH6jfZie8EB5rpw9nuDGN\\n\" +\n" +
            "                    \"sEgEnmK/YrDKqA==")
    .build()