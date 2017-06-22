<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>Welcome to Openfact</title>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="robots" content="noindex, nofollow">

    <link rel="shortcut icon" href="welcome-content/favicon.ico" type="image/x-icon">
    <link rel="StyleSheet" href="welcome-content/openfact.css" type="text/css">
    <style>
        label {
            display: inline-block;
            width: 200px;
            text-align: right;
            margin-right: 10px;
        }

        button {
            margin-left: 215px;
        }

        form {
            background-color: #eee;
            border: 1px solid #666;
            padding-bottom: 1em;
        }

        .error {
            color: #a30000;
        }
    </style>
</head>

<body>
<div class="wrapper">
    <div class="content">
        <div class="logo">
            <img src="welcome-content/openfact_logo.png" alt="Openfact" border="0"/>
        </div>
        <h1>Welcome to Openfact</h1>

    <#if localUser>
        <#--<p>Please create an initial admin user to get started.</p>-->
    <#else>
        <#--<p>-->
            <#--You need local access to create the initial admin user. Open <a href="http://localhost:8080/openfact">http://localhost:8080/openfact</a>-->
            <#--or use the add-user-openfact script.-->
        <#--</p>-->
    </#if>
        
        <p><a href="http://www.openfact.org/docs">Documentation</a> | <a href="admin/">Administration Console</a></p>

        <p><a href="http://www.openfact.org">Openfact Project</a> |
            <a href="https://lists.jboss.org/mailman/listinfo/openfact-user">Mailing List</a> |
            <a href="https://issues.jboss.org/browse/OPENFACT">Report an issue</a></p>
        <p class="logos"><a href="http://www.jboss.org"><img src="welcome-content/jboss_community.png"
                                                             alt="JBoss and JBoss Community" width="254" height="31"
                                                             border="0"></a></p>
    </div>
</div>
</body>
</html>
