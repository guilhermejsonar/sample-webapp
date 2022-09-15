package com.lab.employee.license;

import java.util.Base64;

/*
    PublisherIdentityVersion=0
    IdentityName=imperva
    PublisherName=imperva
    PublisherKey=fbd9fe88
    PublisherKey=aecc9184
    PublisherKey=2657fcc2
    PublisherKey=c9b59e9f
    PublisherKey=746821fc
    SignatureType=RSA
    SignatureStrength=17
*/

public class IdentityClient {

    public static byte[] IDENTITY_DATA = null;

    static {
            String identity_data_base64 =

                "AAAPagAA3UP/////AAAACwByAAAAAAAAAAAPAIACaW1wZXJ2YQAAAAAPAG8CaW1wZXJ2YQAAAAAL"+
                "AG4A+9n+iAAAAAsAbgCuzJGEAAAACwBuACZX/MIAAAALAG4AybWenwAAAAsAbgB0aCH8AAAACwBs"+
                "AAAAAAMAAAALAFMAAAAAEQAABnsAcwtHz2oCXOwAohAExtpyifIDNnxWPr7qmgTNS0gXTpO1AmvD"+
                "SwJiYu4BCyJVr/63VQG6KPuq6HQRAjV1+COiAgMEO9nRHNKqzwDczrdensRWA5e+YI82OYIEWDU0"+
                "PDLFkgEK7G8iJYMSAhojZ8Yf7VQA7kA0zYiXyAJ430sDFNDaA5yG6DCtfrwB7LXHUDAoDAAXvVt6"+
                "cRuwAW0TjmZsExIENv2is3h/ogITmIzDJMUCA0PlQY4/tw0CIQ2iuomibQOLtHibI+x1A4ykFG4x"+
                "Z0IBiIsugV+DbgI/C56hi8vYA3jUaFByNewBBF/w9IAkcAGnPrAibtIdAULEZtu+J5QDMjEDDuF1"+
                "dQJtN+hUMmq1AYqoJu8WzC8EqowbopJZBQSkpcnymr1gBCxyNRLXFRwD4GMuFQiS/gKn+lPERPjF"+
                "AZMJycCtuqwAhDb8ftA0TwLiucLhsD3sBHcGsV2CaPEC75s7DlOLGQAFL02h6i74AVkI37ZNv1wB"+
                "FNFXciAbWAOF+/Ao70ntAGDy44VMMuoE7ELw1eyW3gH4qZqYJuA2AhZGOxZa2yMCCKIQ+aL/0ACo"+
                "CNo45LDwAqaXoqQiqkkD0wW1X9gO+ARcbC4w1jzbAr07H/6lE9oDl3YieaTdpAPghWsYvWyfBPxA"+
                "jmQL8eEEvgxim9kkNQL5ZuPqyvLiAUDNyi4ihHACKYcQSFsSSALisr6QH76fAUJgUHuC+xcDyo8j"+
                "vYE+ygMZ+aovldtMAQiQIWStnjYBMRh+OH8qxQMkZc1c+pSRBBg8+pxhjkEAHOr5kZsFSAKalZbP"+
                "37JSAQmdOiWLkE8E5Qh6rZuNHwDd2p1zBleKBLqw+4JjggwCd7lxZe1DJgDcJfoV1kklAPDN7byH"+
                "x1YB0S0pt3i2mgBAAotY5uRTAeWKENOVnRgBGeghjyaxWADArYKl1QgYA10D/YalMyMEx3G+XPCx"+
                "igIhw1rnTD8MBHBetPdVzI4AIXgDk2nIlACcnso6gpu+AtQVtMRJzTEAT8su/XKNqAJ3JWmBScTZ"+
                "ApT+vaKlXwwDsJ0Mw2CT2QQL18PU5DG5AgGJp/qfewgAg5FqlJLgSwPTTSsAH7y+A+8fmQS5mHIA"+
                "OLDO1eKjwwSvhO4YvQeuBKPwDrzoOooA2UUP0hqLOQHnaJwimWvHAz8B72OIQtgCyk/Nv9i0TQEK"+
                "aGQE7RnQAmS7u2H80icBdUjexH4tGQPHLEfNfmN0A5UWD/EXemMD3gY4dimz+gH8bLSUN7NgALo5"+
                "VG0HJhUAQZLUfPGAaAKhN7HMe3utBIwGFosd1zIBUHQmkMLDHAOpoq+eR5mIA5B/gDQQl0wEA6z3"+
                "b+pMpAJQaPuIKzsoBBxD0xokUUACBGHQP3Ox4QSMDV9Th4RFBH1r6JIQRhsE7NkSO4a5WgK3KOV1"+
                "VlJGAD10CvjHvnsEddzzuta/yQF6J/w9gmgFAlJqioD/SXUD/wIlFmjt4wREyUJChGfZADMOWjGQ"+
                "M8IBUo//494LagS3MdJLl1AeAj8f5UBwJqYEVbN9tLo2OQGlsTu1YN/8Ah2k5lg/sHcAm1IkRRDK"+
                "jQQpUQzwv7naASsgEAmIO/IBPGqDHWb3tQEyawjExvfKAgLTxkskY9oEiigpz8TYBABOivBxv5Sx"+
                "BB5qg2+EHs8DPvQacbFYyQDSNNYo1zVLBLsqsCPRho0AcENeY88k4ADdqlWYoWSbAKBsXWu+dGAE"+
                "Fvr3G+TnEwCjTIKL7gzwAWgoO1tJ8dYDFtK/hQ9SRgM7rBYG1QlyAInM/m21QD4B1OLaGpBhCwHc"+
                "GscUJF3zACOy+2wjF50D7QD7N1qoqwNLF11dGkm+AHo5CZTJCK0AUaQC4Tjj1gNqN/81IZY3A5be"+
                "EGpQbiQCelX/D04PfALcqAEuH/VkA0YNyloP+m0C7N0VDrTTwAA9wHzPIP92AHcHAaCZsyIC648a"+
                "j8I9TgNBPeoAoPTBBKv2/u/OWoIDsIb5USylvQQ847sGYURTAUt9lB1KIaAECvs7YIAw/gM8B+L4"+
                "K0cWAcOQ9Mbfw5YALamqXwt7dwAbkPWJmchPAtz2ib36C98Ang6UkwtCFQOfweiiKaRmAVPOG/qr"+
                "pA0DA7rCdHeRfwBROu91L+2+AMY57HSNbd8BaZl6PxcYvQQ2KB4GW2/KAQaMeFq6PFYET1Hva+WM"+
                "ngLGZA29t8dSA2zQue/isjAE9dDttwAABnsAjAsZH2gCx4EAomCOZhZsYvUDHp/a3wSVYQEY5bTj"+
                "zBWDAS0YXcq3sdwEXnYdQCg5lgBd+B/SCHvKAS1yVp7HnpgEbUc80XQIwQHxKlzPrndcAuIjfZ1v"+
                "Bf8E0r7Emu45BALdIbL5WV/8A/2v8ngn6zoDCEwQL9HgjgE2lVpL5PbDA7XEPh+ezCwAYwqhLxSQ"+
                "kQHSRGYpScr7AbDeqoPSXZwD5nWnHG0EhwChXILC3o6wAYKAIUlDG+8AppTbhSrDJwG9PWCE6IIp"+
                "Ae1ICbKvsLUCYIEk4+2G3ASWLJXDnN9SAn0uadBeWP4CSG35gHVpJgKbMHXmVD1QAtvNog4SKHMD"+
                "ojhxpp+/+AMENxpu25ZXBIBJ8mAbcwsDRjbyUmRG9wMBtlAnRQB2BJBvlerY+I0D0Cbt/WO3swON"+
                "XCBDje3wAjEqh/aj4SgCvy5EF5fkzAG9se64knSyAxlEu9HiVa4EvUGX0OzeXwHc/MBS266ABIyp"+
                "LryvzBMErwI4Jk2OdQC8/J08radHAeC2XZl9wyQC5rmIkaAz/wJAWHzNMPEaAORK9KVZ58EChkAN"+
                "GyZShgLzx4GlzSGCAdjupx1rUvwCSAnf2ntAgQN/VZwFM5h4BKAGjRWHYXsCltwyA2kLVASK0atP"+
                "cJhYA3q4uNgV6rYC//7PWvyFGAH5dlwiQSD2BDSLwErzFeYCkCUvNPU3DATKoVoGYFIEAtCzq4xg"+
                "kJ0AMYGKxyBG3QQP7DPlItUlAJk/YtCbMqQBALah5dX3zQDwbRb2VvQbBMMsSbVJXg8BVXkcKbJ7"+
                "9wGqwgWJnhTyAoGyn3xE1egBXHYrvVs2ngSSQyfygkkdADM+DfJualcAOC4oM9bLeAPcFTfeIIAr"+
                "A17xaUFOBTwAxUA2GhD01QMZQOXPg95BALgLEAa9rqgA5M+apgtIpgIwR2NymSEUAQH4JT7eMcID"+
                "zA7L9j9x8AMEsfBJVL8dBPI3w7XHP24EKVOA2UkDlgMZvwN9vuDAAJafpl/Bs60BsjAASu+MMQMj"+
                "TlVOFYrFBGovP69udBICP/U68nUktgMBUpp+H23bAS1h444gBykBxL4I7ZsyjQA1/JvgcjJqA72C"+
                "36xzSh8BlOPyGmRvdAAxrWVGd9FbBPYSN/JJcbkCbvY7+xJv5gLF/B2pcP+QAmSAz6b4dzUEEad5"+
                "RS7SXgA/ijoBPzU3A1aBsuccRpIAXgl/tZhp4gC8dxUr9BXFBNncwBBEoAMA6IXR1NGgEgQtCMou"+
                "U6xdAfrW9rirJQ0EVpG7lkmdYAQGR8cOWnc/Apk0m6qI0HkBlKRUFA1NHQANOe/HY4hQAVllGkth"+
                "O4ICCOora8RGzASnSzwau2j/A0OahfsLHGQE2909kqPvagN6pdmzKl5SA+UC1PjGCK0CdBXIS1AA"+
                "QgC6bren8dTsAH3e1ItpgOUAO56p2qfTYwIA50nOq6B6ALo7zPra/MgB0TKITfFiiQGJrCNWXACp"+
                "BOB7c2Q8JAoB52nWVIw8/ARhm+8ZcgTGBDizmvejnIkB2AaOJaMIrgMb+BXmEIhFAzgVSkNrEBMA"+
                "VAXho6Za9gJZ7bhcSvOlAOTHdbXLmWoAXWIQvbbNggGnGNTStJwRAAvEPMiLhaQBPXXNuG4AzQKP"+
                "wMCoH8QvAj2KGf9tzdoBngeTKyaRkAG6QFpXou77ASJbVp+bhLIDzkUKHk42kwSR9LksLLh8AlnX"+
                "KQ/rlzgDsR2VC6JVFgR4KHMQnBDkAl/OlR4O5hcD9sigBNQQCAISGq33HlR1AYoayHvqFkMCKOU1"+
                "K9utTwJfii/3JJ0fBPzBBR4HkZEBmb+YtL0zkAOLGX5MTjTCAAk2SNfIRYsDxfJo47+HdQC8bOiW"+
                "9MExACOdii7FWjwD0sGw9A+oCQR9ydQxu88tAddgJYq53GgEtDNF+B0d+QC2NcIPVzJ/A6bdhVAg"+
                "3/UDxbE1ycQxCgKOZpOHXjlzA/5p1bBSG+oBVPsi86/DrQNkx0CfN+83BPfZeZtgbW8E7qHZaPGw"+
                "OAPqcW7+0kiuAQMYAhGxwSYEdfmvpjbEdACVAcWdgYqQApieTbzvTDkCJbFS0rHa+ACLAKN216A3"+
                "ADuEBEpzaBkCpM8ufnMuKgPgDYBNKo1BAqBY6Jz4TSMA69r1oBdKHQCEtGE2FCQ3AE/CRLJC58IA"+
                "vsFBsZkdxQQmIkgAJ4iLBELf/7ZBLfgElefc+AAAAfIAcAsAAgCAAIAAgACgABgALQBCAFcAYADw"+
                "AWQUXwQWfGwBAWx/GwgQZmUxBQANBwkUXwQWfGwBAWx/GwgQZmUxBQANBwkUXwQWfGwBAWx/GwgQ"+
                "ZmUxBQANBwkIViUMAjAbCXACcA+Cl7DHbK0OCdDiR44vvYAsYkYQ1X44ZwuSYFLSotF6H2YKb9XJ"+
                "5BsgL8Pn7hnPc3YoEEVyzMZvsWeH9aBwbm9L0uEOCRGPD4/PK4cPJBIQAAsy5NDbjXHiUuDGCg8i"+
                "7r/egHHjw3AmpnIOCXLfrzVZ7vYkMm1mC0/gF9zPcAS/ZMBQpkTLYwrv+xIpjSACMngwi/8ZDgkR"+
                "wRmyjiePmQyEV2YLEoDRCsxC0OcRtGYKr3y2d65A0W75kP7bdw4JDxLwGUJyjAUPQYz8lyALMDgv"+
                "WPDbeYJhktZmCo9zpMvcQDGVOzFpsUBSZIBvvjGXsODSaPIZCA/JPlMPo48u1miJIAKygJFxrw4J"+
                "UlhRWbiG0JC0NoYLspKSEaXPHz2/+KUKLypbn6SgsVoEcIZ0IYjRjlpg786RoWJgssMP9HxHygTv"+
                "MX/pJQYvnuhFGqAQQepMEiLgsZaX6O+NAlLuwNCp4iLy6A4Jsb/GMLa1JwEyS+ALDyzoVuvQS+hQ"+
                "SDBFJjTkCk8JNQUDIA=="+
                "";

            IDENTITY_DATA = Base64.getDecoder().decode( identity_data_base64 );
        }

}